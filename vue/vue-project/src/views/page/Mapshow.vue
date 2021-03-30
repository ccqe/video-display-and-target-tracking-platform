<template>
  <card>
    <baidu-map id="map"
               :center="mapOption.center" 
               :zoom="mapOption.zoom" 
               :scroll-wheel-zoom="mapOption.scrollWheelZoom"
               @ready="handler" 
               style="height:600px;"  >
    </baidu-map>
  </card>
</template>

<script>
import {getCamera} from '@/api/mapshow'
// import BMap from 'BMap'

const camera = [{
  name:'',
  positionX:0,
  positionY:0,
  peopleNum: 0,  
  vehiclesNum: 0
},{
  name:'',
  positionX:0,
  positionY:0, 
  peopleNum: 0,  
  vehiclesNum: 0
},{
  name:'',
  positionX:0,
  positionY:0,  
  peopleNum: 0,  
  vehiclesNum: 0
},{
  name:'',
  positionX:0,
  positionY:0,   
  peopleNum: 0,  
  vehiclesNum: 0
}]


export default {
  name: 'mapshow',
  data () {
    return {
      mapOption:{
          center: {lng: 114.4404244700, lat: 30.4672142200},
          zoom: 18,
          scrollWheelZoom: true,          
      },     
      camera:camera

    }
  },
  created(){
    this.get()
  },
  methods: {
    handler ({BMap,map}) {
      for (let i = 0; i < this.camera.length; i++) {
        console.log(this.camera[i]);

        this.createPoint({BMap,map},this.camera[i])

        
      }
    },
    createPoint({BMap,map},camera){
      var point = new BMap.Point(camera['positionX'],camera['positionY'])
      var marker = new BMap.Marker(point) 
      map.addOverlay(marker) 

      marker.addEventListener("mouseover",function () {        
        this.openInfoWindow(new BMap.InfoWindow("摄像头："+camera['name']+"人数:"+camera['peopleNum']+"车辆数："+camera['vehiclesNum']))
      })
      marker.addEventListener("mouseout",function () {
        this.closeInfoWindow()
      })

      var self = this;
      marker.addEventListener("click",function () {        
        self.$router.push({ path: '/control'  })
      })
    },
    get(){
      getCamera().then(res=>{
          console.log(res)

          this.camera = res.data.camera
          console.log(this.camera)
          
        })
    
    }
  },
  // watch:{
  //       camera:{
  //           deep:true,
  //           handler:function(newVal,oldVal){
  //               if(newVal){
  //                   console.log("new data")
  //                   for (let i = 0; i < newVal.length; i++) {
  //                     this.createPoint({BMap,map},newVal[i])
  //     }
  //               }else{
  //                   console.log(oldVal)
  //               }
        
  //           }
  //       }
  // }
  
    
}
</script>