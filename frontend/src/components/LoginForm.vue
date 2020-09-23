<template>
  <form @submit.prevent="submit">
  <div class="container">
    <div class="left">
      <div class="header">
        <h2 class="animation a1">STOCK EB에 오신걸 환영합니다</h2>
        <h4 class="animation a2">ID와 Password를 입력해주세요</h4>
      </div>
      <div class="form">
        <input type="username" class="form-field animation a3" placeholder="Username" v-model="userid">
        <input type="password" class="form-field animation a4" placeholder="Password"  v-model="password">
        <p class="animation a5"> 아직 회원이 아니세요?
        <a href="/AdminSetupPage">회원가입</a></p>
        <button id="animation a6" type="submit">LogIn</button>
      </div>
    </div>
    <div class="right"></div>
  </div>
  </form>
</template>

<script>
export default {
  name: 'LoginForm',
  data () {
    return {
      userid: '',
      password: ''
    }
  },
  methods: {
    submit () {
      console.log('LoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    }
  }
}
</script>

<style scoped>

* { box-sizing: border-box; }
@import url('https://fonts.googleapis.com/css?family=Rubik:400,500&display=swap');

body {
  font-family: 'Rubik', sans-serif;
}

.container {
  display: flex;
  height: 100vh;
}

.left {
  overflow: hidden;
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;
  justify-content: center;
  animation-name: left;
  animation-duration: 1s;
  animation-fill-mode: both;
  animation-delay: 1s;
}

.right {
  flex: 1;
  background-color: black;
  transition: 1s;
  background-image: url(https://mk0chaintimescr7bldv.kinstacdn.com/wp-content/uploads/2019/10/blockchain-stocks.jpg);
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}

.header > h2 {
  margin: 0;
  color: #4f46a5;
  text-align: center;
}

.header > h4 {
  margin-top: 20px;
  font-weight: normal;
  font-size: 16px;
  color: #4f46a5;
  text-align: right;
}

.form {
  max-width: 100%;
  display: flex;
  flex-direction: column;
}

.form > p {
  text-align: right;
}

.form > p > a {
  color: #4f46a5;
  font-size: 20px;
}

.form-field {
  height: 46px;
  padding: 0 15px;
  border: 3px solid #ddd;
  border-radius: 4px;
  font-family: 'Rubik', sans-serif;
  outline: 0;
  transition: .2s;
  margin-top: 20px;
}

.form-field:focus {
  border-color: #0f7ef1;
}

.form > button {
  padding: 12px 10px;
  border: 0;
  background: linear-gradient(to right, #de48b5 0%,#0097ff 100%);
  border-radius: 3px;
  margin-top: 10px;
  color: #fff;
  letter-spacing: 1px;
  font-family: 'Rubik', sans-serif;
}

.animation {
  animation-name: move;
  animation-duration: .4s;
  animation-fill-mode: both;
  animation-delay: 2s;
}

.a1 {
  animation-delay: 2s;
}

.a2 {
  animation-delay: 2.1s;
}

.a3 {
  animation-delay: 2.2s;
}

.a4 {
  animation-delay: 2.3s;
}

.a5 {
  animation-delay: 2.4s;
}

.a6 {
  animation-delay: 2.5s;
}

@keyframes move {
  0% {
    opacity: 0;
    visibility: hidden;
    transform: translateY(-40px);
  }

  100% {
    opacity: 1;
    visibility: visible;
    transform: translateY(0);
  }
}

@keyframes left {
  0% {
    opacity: 0;
    width: 0;
  }

  100% {
    opacity: 1;
    padding: 20px 40px;
    width: 440px;
  }
}
</style>
