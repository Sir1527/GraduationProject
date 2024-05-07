<template>
  <div>
    <div style="font-size: 20px">
      血压
      <a-button  shape="circle" :style="{float: 'right',marginRight: '10px'}" @click="handleClick">
        <icon-plus />
      </a-button>
    </div>
    <div id="echarts1" ref="container" style="height: 500px;width: 550px;"></div>
  </div>

  <a-modal v-model:visible="visible" @ok="handleOk" @cancel="handleCancel">
    <template #title>
      新增血压记录
    </template>
    <a-form>
      请输入高压：<br>
      <a-form-item field="username" :validate-trigger="['change', 'blur']" hide-label>
        <a-input placeholder="请输入高压" v-model="form.sbp">
        </a-input>
      </a-form-item>
      请输入低压：<br>
      <a-form-item field="username" :validate-trigger="['change', 'blur']" hide-label>
        <a-input placeholder="请输入低压" v-model="form.dbp">
        </a-input>
      </a-form-item>
    </a-form>
  </a-modal>

</template>

<script setup lang="ts">
import {ref, inject, onBeforeUnmount, onMounted, reactive} from 'vue';
import {reqAddBloodPressureECharts, reqBloodPressureECharts} from "@/api/BloodPressureECharts/BloodPressureECharts";
import type {BloodPressureAdd} from "@/api/BloodPressureECharts/type";
import {getUserId} from "@/utils/auth";

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
        data: time.value
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
        data: time.value
      }
    ],
    yAxis: [
      {
        type: 'value'
      }
    ],
    series: [
      {
        name: '高压',
        type: 'line',
        xAxisIndex: 1,
        smooth: true,
        emphasis: {
          focus: 'series'
        },
        data: sbp.value
      },
      {
        name: '低压',
        type: 'line',
        smooth: true,
        emphasis: {
          focus: 'series'
        },
        data: dbp.value
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


const time: any = ref(Array<string>);
const sbp: any = ref(Array<number>);
const dbp: any = ref(Array<number>);
const load = () => {
  reqBloodPressureECharts('2').then(res => {
    console.log(res)
    time.value = res.data?.time;
    sbp.value = res.data?.sbp;
    dbp.value = res.data?.dbp;
  })
}
onMounted(() => load())

const visible = ref(false);
const handleClick = () => {
  visible.value = true;
};
const handleOk = () => {
  visible.value = false;
  add();
  location.reload();
};
const handleCancel = () => {
  visible.value = false;
}

const id = getUserId();
const form: BloodPressureAdd | any = reactive<BloodPressureAdd>({})
const add = () =>{
  form.userId = id;
  reqAddBloodPressureECharts(form);
}
</script>

<style scoped lang="less">

</style>