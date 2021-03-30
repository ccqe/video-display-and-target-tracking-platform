<template>
  <div>
    <div class="form-box" style="margin-bottom:20px;">
      <card>
                <el-form ref="form" :model="form" label-width="90px">
                    
                    <el-form-item label="摄像头名称">
                        <el-select v-model="form.name" placeholder="请选择">
                            <el-option key="1" label="camera1" value="camera1"></el-option>
                            <el-option key="2" label="camera2" value="camera2"></el-option>
                            <el-option key="3" label="camera3" value="camera3"></el-option>
                            <el-option key="4" label="camera4" value="camera4"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="日期时间">
                        <el-col :span="11">
                            <el-date-picker
                                type="date"
                                placeholder="选择日期"
                                v-model="form.date"
                                value-format="yyyy-MM-dd"
                                style="width: 100%;"
                            ></el-date-picker>
                        </el-col>
                        <el-col class="line" :span="2">-</el-col>
                        <el-col :span="11">
                            <el-time-picker
                                placeholder="选择时间"
                                v-model="form.time"
                                style="width: 100%;"
                            ></el-time-picker>
                        </el-col>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="info" @click="onSubmit">查找</el-button>
                    </el-form-item>
                </el-form>
        </card>
    </div>
    <Card v-if="showVideo" style="margin-right:20%;">
      <!-- <h1 ref="playerOptionsDiv">{{playerOptions['sources'][0]['src']}}</h1>              -->
      <video-player class="video-player vjs-custom-skin"
                      ref="videoPlayer"
                      :playsinline="true"
                      :options="playerOptions"                     
                      >
      </video-player>
    </Card> 
  </div>
</template>

<script>
import {getVideo} from '@/api/playback'

export default {
    data() {
        return {
            form:{
              name:'',
              date:'',
              time:''
            },
            showVideo:false,
            playerOptions: {
                playbackRates: [0.5, 1.0, 1.5, 2.0], 
                autoplay: false, 
                muted: false, 
                loop: false, 
                preload: 'auto',                     
                language: 'zh-CN',
                aspectRatio: '16:9',
                fluid: true,
                sources: [{
                    type: "video/mp4",
                    src: '' 
                }],
                poster: '', 
                controlBar: {
                timeDivider: true,
                durationDisplay: true,
                remainingTimeDisplay: false,
                fullscreenToggle: true  
                }
            }
        }
    },
    methods:{
      onSubmit() {
            this.$message.success('提交成功！');
            console.log(this.form)
             this.get()
      },
      get(){
        getVideo({
              name:this.form.name,
              date:this.form.date,
              time:this.form.time,
        }).then(res=>{
          console.log(res)

          this.playerOptions['sources'][0]['src'] = res.data.src
          this.showVideo=true 
        })
      }
    }
}
</script>

<style>
.form-box {
    width: 800px;
}

.form-box .line {
    text-align: center;
}

</style>