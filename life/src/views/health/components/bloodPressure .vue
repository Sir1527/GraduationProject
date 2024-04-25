<template>
  <div>
    <div id="echarts1" ref="container" style="height: 500px;width: 500px;"></div>
  </div>


</template>

<script setup lang="ts">
import { ref, inject, onBeforeUnmount} from 'vue';

// 获取echart挂载的DOM节点
const container = ref();

// 定义延时器指针对象，便于组件实例销毁的时候以便清除
const timer = ref();

// 通过 inject 接收Echarts
const Echarts = inject('$echarts');

// 或
// 通过Vue全局注册方式获取
// const {proxy}: any = getCurrentInstance();

const colors = ['#5470C6', '#EE6666'];
const initEchartsOneFn = () => {
  // echarts初始化
  const myChart = (Echarts as any).init(container.value);

  // 或
  // let myChart = proxy.$echarts.init(container.value);

  const option = {
    // 自定义echarts图标相关配置
    color: colors,

    tooltip: {
      trigger: 'none',
      axisPointer: {
        type: 'cross'
      }
    },

    legend: {},
    grid: {
      top: 70,
      bottom: 50
    },

    xAxis: [
      {
        type: 'category',
        axisLine: {
          onZero: true,
          lineStyle: {
            color: colors[1]
          }
        },
        // prettier-ignore
        data: ['2016-1', '2016-2', '2016-3', '2016-4', '2016-5', '2016-6', '2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12']
      },
      {
        type: 'category',
        axisTick: {
          alignWithLabel: true
        },
        axisLine: {
          onZero: false,
          lineStyle: {
            color: colors[0]
          }
        },

      }
    ],
    yAxis: [
      {
        type: 'value'
      }
    ],
    series: [
      {
        name: 'Precipitation(2015)',
        type: 'line',
        xAxisIndex: 1,
        smooth: true,
        emphasis: {
          focus: 'series'
        },
        data: [
          1, 12, 10.0, 12, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3
        ]
      },
      {
        name: 'Precipitation(2016)',
        type: 'line',
        smooth: true,
        emphasis: {
          focus: 'series'
        },
        data: [
          200,5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 46.6, 55.4, 18.4, 10.3, 0.7
        ]
      }
    ]
  };

  myChart.setOption(option);

  // 根据页面大小自动响应图表大小
  window.addEventListener("resize", function () {
    myChart.resize();
  });
}

// 判断定时器是否存在
if (timer.value) {
  clearTimeout(timer.value);
}

// 绑定定时器，销毁的时候再次清除
timer.value = setTimeout(() => initEchartsOneFn(), 1000);

// 组件实例销毁前清除延时器对象
onBeforeUnmount(() => {
  if (timer.value) clearTimeout(timer.value);
});

</script>

<style scoped lang="less">

</style>