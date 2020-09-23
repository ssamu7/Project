<template>
  <v-app id="inspire">
    <v-app-bar
      app
      clipped-right
      color="green"
      dark
    >
      <v-toolbar-title><div @click="home">&copy; StockEB</div></v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>
      <v-btn @click="category()" text color="black"
        style="padding: 30px; width: 150px; font-weight: bold;">Stock Info</v-btn>
      <v-btn @click="board()" text color="black"
        style="padding: 30px; width: 150px; font-weight: bold;">News Board</v-btn>
      <v-btn @click="onClickLogout" text color="black"
        style="padding: 30px; width: 150px; font-weight: bold;">Logout</v-btn>
    </v-app-bar>
     <v-container>
      <v-main id="content">
        <slot name="content" class="font">
        </slot>
      </v-main>
    </v-container>

    <v-footer
      app
      color="green"
      class="white--text"
    >
      <v-spacer></v-spacer>
      <span>&copy; StockEB</span>
    </v-footer>
  </v-app>
</template>

<script>
import router from '../router'
import { mapState, mapGetters, mapActions } from 'vuex'

export default {
  data: () => ({
    drawer: false,
    left: false
  }),
  methods: {
    home () {
      (window.location.pathname !== '/home2') ? router.push('/home2') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/NewsAndBlogPage') ? router.push('/NewsAndBlogPage') : router.go(0)
    },
    board () {
      (window.location.pathname !== '/CrawlCategory') ? router.push('/CrawlCategory') : router.go(0)
    },
    onClickLogout () {
      this.logout()
      alert('로그아웃 되었습니다.')
      this.$router.push({ name: 'Home' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
  }
}
</script>

<style>
p {
    font-weight: normal;
    font-size: 16px;
    font-family: 'Rubik', sans-serif;
    text-align: center;
}

p1 {
    font-weight: bold;
    font-size: 18px;
    font-family: 'Rubik', sans-serif;
}

</style>
