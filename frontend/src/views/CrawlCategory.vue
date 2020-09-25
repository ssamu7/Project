<template>
  <div class="hello">
    <div class="container">
      <form class="navbar-form m-2">
        <div class="input-group no border">
          <input type="text" value="" class="form-comntrol" placeholder="Search.."
          v-model="stock">
          <i @click="getInfo(stock)" class="material-icons ml-3">search</i>
        </div>
      </form>

      <div class="row">
        <div class="col-md-3">
          <div class="card card-stats card-background">
            <div class="card-header card-header-icon">
              <div class="card-icon">
                <i class="material-icons">content_copy</i>
              </div>
              <p class="card-category">Beta</p>
              <h4 class="card-title" align="center">1.32</h4>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card card-stats card-background">
            <div class="card-header card-header-icon">
              <div class="card-icon">
                <i class="material-icons">store</i>
              </div>
             <p class="card-category">CEO</p>
              <h4 class="card-title" align="center">Mr. Timothy Cook</h4>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card card-stats card-background">
            <div class="card-header card-header-icon">
              <div class="card-icon">
                <i class="material-icons">info</i>
              </div>
              <p class="card-category">Comp. Name</p>
              <h4 class="card-title" align="center">Apple Inc</h4>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card card-stats card-background">
            <div class="card-header card-header-icon">
              <div class="card-icon">
                <i class="material-icons">storage</i>
              </div>
              <p class="card-category">Sector</p>
              <h4 class="card-title" align="center">Technology</h4>
            </div>
          </div>
        </div>

        <div class="col-md-12">
          <md-list>
            <v-col>
              <md-list-item class="col-md-3">
               <md-icon>timeline</md-icon>
               <span class="left">Price $107.12</span>
              </md-list-item>
            </v-col>
            <v-col>
              <md-list-item class="col-md-3" align="center">
               <md-icon>money</md-icon>
               <span class="left">ROA TBD%</span>
              </md-list-item>
            </v-col>
            <v-col>
              <md-list-item class="col-md-3">
               <md-icon>storage</md-icon>
               <span class="left">ROE TBD</span>
              </md-list-item>
            </v-col>
          </md-list>
        </div>
    </div>
          <HomeLayOut></HomeLayOut>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import HomeLayOut from '@/components/HomeLayOut.vue'

export default {
  name: 'StockInfo',
  components: {
    HomeLayOut
  },
  data () {
    return {
      stock: '',
      beta: '',
      infoCompany: '',
      CEO: '',
      sector: '',
      companyName: '',
      price: '',
      marketCap: '',
      image: '',
      description: ''
    }
  },
  methods: {
    getInfo (stock) {
      console.log('stock')
      axios.get('https://financialmodelingprep.com/api/v3/profile/AAPL?apikey=a3ca968322703f3f27009b0d0cca7e4b')
        .then(res => {
          this.infoCompany = res.data
          this.beta = this.infoCompany.beta
          this.CEO = this.infoCompany.ceo
          this.sector = this.infoCompany.sector
          this.companyName = this.infoCompany.companyName
          this.price = this.infoCompany.price
          this.marketCap = this.infoCompany.mktCap
          this.image = this.infoCompany.image
          this.description = this.infoCompany.description
        })
        .catch(err => console.log(err))
    }
  }
}
</script>

<style scoped>

.card-background {
    background-color: green;
    color:white
  }

.md-list {
    max-width: 100%;
    dispaly: inline-block;
    vertical-align: top;
    border: 1px solid rgba(#000, .12);
  }

.left {
    margin-right: 12px;
    margin-top: 0px;
  }

.right {
    margin-left: 10px;
     margin-top: px;
  }

</style>
