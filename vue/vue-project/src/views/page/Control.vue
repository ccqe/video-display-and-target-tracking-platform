<template>
  <div v-if="showRtmp">
    <Row type="flex" justify="center" :gutter="20">
      <i-col :span="18">
        <Row type="flex" justify="start" :gutter="20" >
          <i-col :span="12" v-for="(item, i) in rtmpInfo" :key="`info-${i}`" style="margin-bottom:30px;">
            <Card>
              <p slot="title" style="">{{item.name}}</p>
              <div >
                <rtmp-live :src="item.rtmpSrc"></rtmp-live>
              </div>
            </Card>
          </i-col>
        </Row>
      </i-col>
    </Row>
  </div>
</template>

<script>
import RtmpLive from '@/components/live/Rtmp.vue';
import {getRtmp} from '@/api/control';

export default {
  name: "control",
  components: {
    RtmpLive,
  },
  data () {
    return {
      showRtmp:false,
      rtmpInfo: [
        { name: '', rtmpSrc: ''},
        { name: '', rtmpSrc: ''},
        { name: '', rtmpSrc: ''},
        { name: '', rtmpSrc: ''}
      ],
      imgSrc: '', 
      canvas: '',
      context: '',
      videoTag: ''
    }
  },
  created() {
    this.get();
  },
  methods:{
    get(){
        getRtmp().then(res=>{
          console.log(res)

          this.rtmpInfo = res.data.rtmpInfo
          this.showRtmp=true
        })
    }
  }
}
</script>