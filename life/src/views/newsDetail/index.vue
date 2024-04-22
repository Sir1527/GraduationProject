<template>

  <div class="container">
    <a-card :bordered="false">
      <div class="main-content">
        <div style="margin-bottom: 20px; font-size: 22px; font-weight: bold; text-align: center">
          <a-typography-title :heading="2">
           {{ news.title }}
          </a-typography-title>
        </div>

        <div style="color: #666; text-align: center">
          <span style="margin-right: 20px">发布时间：{{ news.time }}</span>
          <span>浏览量：<span style="color: red">{{ news.count }}</span></span>
        </div>
        <div style="margin: 30px 0; padding: 0 20px">
          <div class="w-e-text" style="line-height: 26px; text-indent: 2rem">
            <div>
              <div v-html="news.content"></div>
            </div>
          </div>
        </div>
      </div>
    </a-card>

  </div>

</template>

<script setup lang="ts">

import {reactive} from "vue";

const news = reactive({
  id:'9',
  title: '特困老人的“温暖使者',
  descr: '记沭阳县贤官镇敬老院院长杨光来',
  content: '<p style=\\"text-align:left;\\">情暖寒冬，关爱老人。为进一步弘扬尊老、敬老、爱老的传统美德，做好老年人医疗服务，传播健康理念，12月26日，省市卫健领导、济南市医养健康产业协会“暖冬敬老”系列活动走进历城区养老服务中心。山东省卫生健康委中医产业处处长王萱、济南市卫生健康委医养健康处二级调研员王芝美、历城区卫健局、济南市第三人民医院及等协会相关领导等参加活动。现场举行了“暖冬敬老”慰问捐赠仪式、开展了老年营养保健讲座及市立三院的公益诊疗活动。</p><p><br/></p><p style=\\"text-align:center;\\"><a href=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/385e9b0762a44d5ff68aeb75e9bc8b41.jpg\\" target=\\"_blank\\"><img alt=\\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\\" src=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/385e9b0762a44d5ff68aeb75e9bc8b41.jpg\\"/></a></p><p style=\\"text-align:left;\\"><br/></p><p style=\\"text-align:left;\\">领导一行参观了养老中心各功能区域，深入了解了中心医疗保健、康复护理、中医理疗、认知照护等医养结合服务内容，并对中心医疗设施设备及专业化服务给予充分肯定。</p><p><br/></p><p style=\\"text-align:center;\\"><a href=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9ae65ee1a52ec263b44b1fdb2bd64bd5.jpg\\" target=\\"_blank\\"><img alt=\\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\\" src=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9ae65ee1a52ec263b44b1fdb2bd64bd5.jpg\\"/></a></p><p style=\\"text-align:left;\\"><br/></p><p style=\\"text-align:left;\\">参观结束在中心举行“暖冬敬老”慰问捐赠仪式，山东省卫生健康委中医产业处给养老中心赠送了老年人营养膳食指南等书籍，协会为中心长者送来米面粮油等生活物资，不仅强化了入住老人的物质生活保障，更丰富了长者的精神文化生活。</p><p><br/></p><p style=\\"text-align:center;\\"><a href=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9d0adada38674523476037b919b6fb3d.jpg\\" target=\\"_blank\\"><img alt=\\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\\" src=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9d0adada38674523476037b919b6fb3d.jpg\\"/></a></p><p style=\\"text-align:left;\\"><br/></p><p style=\\"text-align:left;\\">“暖冬敬老”活动现场，济南市第三人民医院副主任医师杨其军为中心在住长者带来老年营养保健讲座，现场普及营养与健康知识，有效增强老年人的健康意识和自我保健能力，养成健康、文明、科学的生活习惯，预防和延缓疾病的发生和发展，提升生命质量。</p><p><br/></p><p style=\\"text-align:center;\\"><a href=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/5ceeeec97d0141bb41e769df8532318b.jpg\\" target=\\"_blank\\"><img alt=\\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\\" src=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/5ceeeec97d0141bb41e769df8532318b.jpg\\"/></a></p><p style=\\"text-align:left;\\"><br/></p><p style=\\"text-align:left;\\">市立三院为中心长者提供义诊服务，心血管内科、神经外科、脊柱外科、心血管内科、泌尿外科、中医科等科室医师现场为长者们进行了生命体征测量等医疗诊断服务，并将移动医疗车开进养老中心，给老人做CT、B超检查，耐心倾听长者各类问题，给予专业的建议和解答，受到中心长者们的一致欢迎。</p><p><br/></p><p style=\\"text-align:center;\\"><a href=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8f45ff5fae34b96c43f554147ee6b975.jpg\\" target=\\"_blank\\"><img alt=\\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\\" src=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8f45ff5fae34b96c43f554147ee6b975.jpg\\"/></a></p><p style=\\"text-align:center;\\"><a href=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/26a675fd016e44ef3e6d024a81d6f58b.jpg\\" target=\\"_blank\\"><img alt=\\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\\" src=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/26a675fd016e44ef3e6d024a81d6f58b.jpg\\"/></a></p><p style=\\"text-align:left;\\"><br/></p><p style=\\"text-align:left;\\">此次“暖冬敬老”活动是济南市医养健康产业协会各级领导关心关注老年群体、践行爱老初心的有力实践。历城区养老服务中心负责人表示，中心将用优质的医养结合专业服务，让入住长者老有所养、老有所医，为在住长者持续打造高品质晚年生活。</p><p><br/></p><p style=\\"text-align:center;\\"><a href=\\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8799a30e1062421e00e2bae5f634bfbc.jpg\\" target=\\"_blank\\"><img alt="市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容" src="https://www.yanglaocn.com/images/upload/img/2023/12_27/8799a30e1062421e00e2bae5f634bfbc.jpg"/></a></p><p style=\\"text-align:center;\\"><a href=\\"https://www.yanglaocn.com/images/upload/img/2023/12_13/885e29bf31d55a7065303bc7dff2f2c3.png\\" target=\\"_blank\\"><img src="https://www.yanglaocn.com/images/upload/img/2023/12_13/885e29bf31d55a7065303bc7dff2f2c3.png"/></a></p>',
  cover: 'https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20240329\\/20240329113829_9a09b02696dd43558367fddff1fa5ad8_1_mwpm_03201609.jpeg',
  time: '2023-12-29 16:28:55',
  count: '245',
  category: '养老动态'
})

</script>

<style scoped lang="less">

.container {
  padding: 16px 0 20px 0;
}

.main-content {
  margin: 10px auto;
}

</style>