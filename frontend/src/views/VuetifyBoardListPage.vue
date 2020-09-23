<template>
  <div align="center">
    <h2>Vuetify Real Board List</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      Create New Board
    </router-link>
    <board-list-page-form :list-array="pageArray"/>
    <HomeLayOut></HomeLayOut>
  </div>
</template>

<script>
import axios from 'axios'
import BoardListPageForm from '@/components/BoardListPageForm.vue'
import HomeLayOut from '@/components/HomeLayOut.vue'
export default {
  name: 'VuetifyBoardListPage',
  components: {
    BoardListPageForm,
    HomeLayOut
  },
  data () {
    return {
      pageArray: [],
      pageSize: 3
    }
  },
  created () {
    axios.get('http://localhost:7777/boards')
      .then(res => {
        console.log(res)
        this.pageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>
