<template>
    <home-lay-out>
    <template #content>
    <v-row>
      <v-col align="center">
        <v-img src="../img/stock.png" alt="My Image" width="550" height="300"/>
      </v-col>
    </v-row>
    <p style="margin:15px"><p1>StockEB(Stock EarlyBird)</p1>
    는 일찍 일어나는 새가 벌레를 잡아먹듯 이용자가 자신의 입맛에 맞는 주식 정보들을 선점하도록 지원하고자 합니다.<br>
    자신이 보유하고 있는 주식에 관한 뉴스와 함께 성공적인 투자를 위하여 신규 상장, 공시 등 중요 뉴스들을 발빠르게 제공하고 있습니다.<br>
    또한, 사용자가 투자한 기업의 실시간 주가와 재무제표를 함께 제공하여 즉각적인 투자 대응을 돕고자 합니다.</p>
    <div id="chartdiv"/>
    </template>
  </home-lay-out>
</template>

<script>
import HomeLayOut from '../components/HomeLayOut'
import { mapState } from 'vuex'
/* Imports */
import * as am4core from '@amcharts/amcharts4/core'
import * as am4charts from '@amcharts/amcharts4/charts'
import animated from '@amcharts/amcharts4/themes/animated'

/* Chart code */
// Themes begin
am4core.useTheme(animated)
// Themes end

export default {
  name: 'Home',
  components: { HomeLayOut },
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickNews (newsNo) {
      console.log('clickNews: ' + newsNo)
      this.$store.dispatch('crawlFindOne', newsNo)
    },
    start (category) {
      this.$store.dispatch('crawlFind', category)
    }
  },
  mounted () {
    // Create chart instance
    const chart = am4core.create('chartdiv', am4charts.XYChart)

    // Add data
    // chart.data = generateChartData()

    // Create axes
    const dateAxis = chart.xAxes.push(new am4charts.DateAxis())
    dateAxis.renderer.minGridDistance = 50

    const valueAxis = chart.yAxes.push(new am4charts.ValueAxis())
    console.log(valueAxis)

    // Create series
    const series = chart.series.push(new am4charts.LineSeries())
    series.dataFields.valueY = 'visits'
    series.dataFields.dateX = 'date'
    series.strokeWidth = 2
    series.minBulletDistance = 10
    series.tooltipText = '{valueY}'
    series.tooltip.pointerOrientation = 'vertical'
    series.tooltip.background.cornerRadius = 20
    series.tooltip.background.fillOpacity = 0.5
    series.tooltip.label.padding(12, 12, 12, 12)

    // Add scrollbar
    chart.scrollbarX = new am4charts.XYChartScrollbar()
    chart.scrollbarX.series.push(series)

    // Add cursor
    chart.cursor = new am4charts.XYCursor()
    chart.cursor.xAxis = dateAxis
    chart.cursor.snapToSeries = series

    const chartData = []
    const firstDate = new Date()
    firstDate.setDate(firstDate.getDate() - 1000)
    let visits = 1200
    for (var i = 0; i < 500; i++) {
      // we create date objects here. In your data, you can have date strings
      // and then set format of your dates using chart.dataDateFormat property,
      // however when possible, use date objects, as this will speed up chart rendering.
      const newDate = new Date(firstDate)
      newDate.setDate(newDate.getDate() + i)

      visits += Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 10)

      chartData.push({
        date: newDate,
        visits: visits
      })
    }
    chart.data = chartData.slice()
  }
}
</script>
<style>
#chartdiv {
  height: 600px;
  width: 1200px;
}
</style>
