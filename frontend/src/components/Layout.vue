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
    </v-app-bar>
    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
        </slot>
      </v-content>
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

export default {
  data: () => ({
    drawer: false,
    left: false
  }),
  methods: {
    home () {
      (window.location.pathname !== '/home2') ? router.push('/home2') : router.go(0)
    }
  }
}
</script>
