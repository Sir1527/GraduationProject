<template>
  <div>
    <div style="font-size: 20px">
      血糖
      <a-button  shape="circle" :style="{float: 'right',marginRight: '10px'}" @click="handleClick">
        <icon-plus />
      </a-button>
    </div>
    <div id="echarts1" ref="container" style="height: 350px;width: 550px;"></div>
  </div>

  <a-modal v-model:visible="visible" @ok="handleOk" @cancel="handleCancel">
    <template #title>
      新增血糖记录
    </template>
      请输入血糖值：<br>
      <a-form-item field="username" :validate-trigger="['change', 'blur']" hide-label>
        <a-input placeholder="请输入血糖值" v-model="form.glu"></a-input>
      </a-form-item>
  </a-modal>
</template>

<script setup lang="ts">
import {inject, onBeforeUnmount, onMounted, reactive, ref} from "vue";
import type {WeightAdd} from "@/api/Weight/type";
import {reqWeightECharts} from "@/api/Weight/Weight";
import {reqAddGluECharts, reqGluECharts} from "@/api/Glu/Glu";
import {getUserId} from "@/utils/auth";
import type {GluAdd} from "@/api/Glu/type";

const visible = ref(false);
const handleClick = () => {
  visible.value = true;
};
const handleOk = () => {
  add();
  visible.value = false;
  location.reload();
};
const handleCancel = () => {
  visible.value = false;
}

const id = getUserId();
const glu:any = ref(Array<number>);
const time:any = ref(Array<String>);
const load = () => {
  reqGluECharts(id).then(res => {
    glu.value = res.data.glu;
    time.value = res.data.time;
  })
}
onMounted( () => load())

const form: GluAdd | any = reactive<GluAdd>({});
const add = () => {
  form.userId = id;
  reqAddGluECharts(form).then(res => {
  });
}


const container = ref();
const timer = ref();
const Echarts = inject('$echarts');
const initEchartsOneFn = () => {
  const myChart = (Echarts as any).init(container.value);
  const option = {
    xAxis: {
      type: 'category',
      data: time.value
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        data: glu.value,
        type: 'line',
        smooth: true
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