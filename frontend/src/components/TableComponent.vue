<template>
  <table>
    <tr-component
      v-for="(rowData, index) in tableData"
      :key="index"
      :row-data="rowData"
      :row-index="index"
      :table-data="tableData"
      :turn="turn"
      :winner="winner"
      v-on:updateTurn="updateTurn"
      v-on:updateTableData="updateTableData"
      v-on:updateWinner="updateWinner"
      v-model="propTurn"
    ></tr-component>
  </table>
</template>

<script>
import TrComponent from './TrComponent'
export default {
  data () {
    return {
      propTurn: this.turn,
      propWin: this.winner
    }
  },
  components: {
    TrComponent
  },
  props: {
    tableData: Array,
    turn: String,
    winner: String
  },
  updated: function () {
    console.log('tableData: ' + this.tableData +
                ', turn: ' + this.turn +
                ', winner: ' + this.winner)
  },
  methods: {
    updateTurn: function (val) {
      console.log('TableComponent updateTurn: ' + val)
      this.propTurn = val
      this.$emit('updateTurn', this.propTurn)
    },
    updateTableData: function () {
      this.$emit('updateTableData')
    },
    updateWinner: function (val) {
      this.propWin = val
      this.$emit('updateWinner', this.propWin)
    }
  }
}
</script>
