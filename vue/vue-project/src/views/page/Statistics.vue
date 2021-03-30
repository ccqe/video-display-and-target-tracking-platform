<template>
    <div>
        <div>
            <el-form ref="form" :model="form" label-width="90px">                  
                    <el-form-item label="摄像头名称">
                        <el-select v-model="form.name" placeholder="请选择">
                            <el-option key="1" label="camera1" value="camera1"></el-option>
                            <el-option key="2" label="camera2" value="camera2"></el-option>
                            <el-option key="3" label="camera3" value="camera3"></el-option>
                            <el-option key="4" label="camera4" value="camera4"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="info" @click="onSubmit">查找</el-button>
                    </el-form-item>
            </el-form>
        </div>
        <div style="margin-top:20px;">
            <div id="chart" style="height:600px;width:900px;"></div>
        </div>
    </div>
</template>

<script>
import {getData} from '@/api/statistics'

var echarts = require('echarts');
var myChart;

const option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            crossStyle: {
                color: '#999'
            }
        }
    },
    toolbox: {
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            saveAsImage: {show: true}
        }
    },
    legend: {
        data: ['人数', '车辆数']
    },
    xAxis: [
        {
            type: 'category',
            name: '时刻',
            data: ['0','1', '2', '3', '4', '5', '6', '7', '8', '9', '10','11', '12', '13','14','15','16', '17', '18', '19', '20', '21', '22', '23'],
            axisPointer: {
                type: 'shadow'
            }
        }
    ],
    yAxis: [
        {
            type: 'value',
            name: '数量',
            min: 0,
            // max: 250,
            interval: 1000,
            axisLabel: {
                formatter: '{value} '
            }
        }
    ],
    series: [
        {
            name: '人数',
            type: 'bar',
            data: []
        },
        {
            name: '车辆数',
            type: 'bar',
            data: []
        }
    ]
}

export default {
    name: 'statistics',
    data() {
        return {
            form:{
              name:''
            },
            option : option
        };
    },
    mounted(){
        this.createEcharts()
    },
    created(){
        // this.get()
    },
    methods: {
        createEcharts(){
            myChart = echarts.init(document.getElementById('chart'));
            myChart.setOption(option);
        },
        onSubmit(){
            this.get()
        },
        get(){
            getData({
                name:this.form.name,
            }).then(res=>{
            console.log(res)
            
            this.option['series'][0]['data']=res.data.data[0]
            this.option['series'][1]['data']=res.data.data[1]
            
        })
        }
    },
    watch:{
        option:{
            deep:true,
            handler:function(newVal,oldVal){
                if(newVal){
                    console.log("new data")
                    myChart.setOption(newVal,true)
                }else{
                    myChart.setOption(oldVal,true)
                }
                myChart.resize()
            }
        }
    }

}
</script>

<style>
</style>