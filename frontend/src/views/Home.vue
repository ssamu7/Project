<template>
  <div align="center">
    <login-form @submit="onSubmit"/>
  </div>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'
import { mapActions } from 'vuex'

export default {
  name: 'Home',
  components: {
    LoginForm
  },
  methods: {
    onSubmit (payload) {
      console.log('loginPage onSubmit()')
      this.login(payload).then(res => {
        alert('로그인 되었습니다')
        this.$router.push({ name: 'Home2' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('ID 또는 Password가 잘못 입력되었습니다', err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>
