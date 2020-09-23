<template>
  <v-main>
    <div align="center">
      <h1>투자 기업의 뉴스를 검색해보세요</h1>
      <div class="form">
          <input type="sm" class="form-field animation a3" placeholder="회사명을 입력해주세요" v-model="sm">
          <input type="num" class="form-field animation a4" placeholder="몇 페이지를 크롤링할까요?" v-model="num">
          <button id="animation a6" type="submit" @click="search()">검색</button>
      </div>
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
              <th>Title.</th>
              <th>Link</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="num2 of num1" :key="num2">
              <td style="color: green">{{ a[num2][0] }}</td>
              <td><a :href="a[num2][1]">${{ a[num2][1] }}</a></td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
      <HomeLayOut></HomeLayOut>
    </div>
  </v-main>
</template>

<script>
import axios from 'axios'
import HomeLayOut from '@/components/HomeLayOut.vue'
export default {
  name: 'NewsAndBlogPage',
  components: {
    HomeLayOut
  },
  data () {
    return {
      sm: '',
      num: '',
      num1: 0,
      a: []
    }
  },
  methods: {
    search () {
      console.log('created : created')
      const { sm, num } = this
      axios.post('http://localhost:5000/dataServer', { sm, num })
        .then(res => {
          console.log('res.data : ' + res.data)
          this.a = res.data
          this.num1 = this.num * 10
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style scoped>
.form {
  max-width: 20%;
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
  height: 30px;
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
  background: green;
  border-radius: 3px;
  margin-top: 10px;
  color: #fff;
  letter-spacing: 1px;
  font-family: 'Rubik', sans-serif;
}

th {
  text-align: left;
  font-size: 20px !important;
  font-weight: bold;
  }
</style>
