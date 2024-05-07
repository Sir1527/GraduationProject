<template>
  <div>
    <div style="font-size: 20px">
      体重
      <a-button  shape="circle" :style="{float: 'right',marginRight: '10px'}" @click="handleClick">
        <icon-plus />
      </a-button>
    </div>
    <div id="echarts1" ref="container" style="height: 500px;width: 550px;"></div>
  </div>

  <a-modal v-model:visible="visible" @ok="handleOk" @cancel="handleCancel">
    <template #title>
      新增体重记录
    </template>
    <a-form>
      请输入体重(单位：kg)：<br>
      <a-form-item field="username" :validate-trigger="['change', 'blur']" hide-label>
        <a-input placeholder="请输入体重" v-model="form.weight"></a-input>
      </a-form-item>
      请输入体脂率：<br>
      <a-form-item field="username" :validate-trigger="['change', 'blur']" hide-label>
        <a-input placeholder="请输入体脂率" v-model="form.bmi"></a-input>
      </a-form-item>
    </a-form>
  </a-modal>

</template>

<script setup lang="ts">
import {ref, inject, onBeforeUnmount, onMounted, reactive} from 'vue';
import type {WeightAdd} from "@/api/Weight/type";
import {getUserId} from "@/utils/auth";
import {reqGetWeightECharts, reqWeightECharts} from "@/api/Weight/Weight";

const id = getUserId();
const weight:any = ref(Array<String>);
const bmi:any = ref(Array<String>);
const time:any = ref(Array<String>);

const load = () => {
  reqGetWeightECharts(id).then(res => {
    weight.value = res.data?.weight;
    bmi.value = res.data?.bmi;
    time.value = res.data?.time;
    console.log(weight.value);
    console.log(bmi.value);
    console.log(time.value);
  })
}
onMounted( () => load())

const visible = ref(false);
const handleClick = () => {
  visible.value = true;
};
const handleOk = () => {
  visible.value = false;
  add()
  location.reload();
};
const handleCancel = () => {
  visible.value = false;
}

const form: WeightAdd | any = reactive<WeightAdd>({});
const add = () => {
  form.userId = id;
  reqWeightECharts(form)
}

const container = ref();
const timer = ref();
const Echarts = inject('$echarts');
const initEchartsOneFn = () => {
  const myChart = (Echarts as any).init(container.value);
  const option = {
    tooltip: {
      trigger: 'axis',
      axisPointer: {
        type: 'cross',
        label: {
          backgroundColor: '#6a7985'
        }
      }
    },
    legend: {
      data: ['体脂', '体重']
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    xAxis: [
      {
        type: 'category',
        boundaryGap: false,
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
        name: '体脂',
        type: 'line',
        stack: 'Total',
        areaStyle: {},
        emphasis: {
          focus: 'series'
        },
        data: bmi.value
      },
      {
        name: '体重',
        type: 'line',
        stack: 'Total',
        areaStyle: {},
        emphasis: {
          focus: 'series'
        },
        data: weight.value
      },
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