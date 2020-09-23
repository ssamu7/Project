<template>
  <div class="hello">
    <div class="container">
      <form class="navbar-form m-2">
        <div class="input-group no border">
          <input type="text" value="" class="form-comntrol" placeholder="Search.."
          v-model="stock">
          <button @click="update(stock)" class="btn btn-white btn-round bn-just-icon">
            <i class="material-icons ml-3">search</i>
          </button>
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
              <h4 class="card-title">{{this.beta}}</h4>
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
              <h4 class=card-title>{{this.CEO}}</h4>
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
              <h4 class=card-title>{{this.companyName}}</h4>
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
              <h4 class=card-title>{{this.sector}}</h4>
            </div>
          </div>
        </div>

      </div>
  <div class="row">
    <div class="col-md-12">
      <md-list>
        <md-list-item class="col-md-3">
         <md-icon>timeline</md-icon>
         <span class="left">Price TBD</span>
         <span class="right">P/B TBD</span>
        </md-list-item>

        <md-list-item class="col-md-3">
         <md-icon>attatch_money</md-icon>
         <span class="left">ROA TBD%</span>
         <span class="right">P/S TBD</span>
        </md-list-item>

        <md-list-item class="col-md-3">
         <md-icon>attatch_money</md-icon>
         <span class="left">ROE TBD</span>
         <span class="right">P/E TBD</span>
        </md-list-item>

        <md-list-item class="col-md-3">
         <md-icon>bar_chart</md-icon>
         <span class="left">Gross Profit Mar TBD%</span>
        </md-list-item>
      </md-list>
    </div>
  </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'StockInfo',
  props: {
    msg: String
  },
  data () {
    return {
      stock: '',
      beta: '',
      infoCompany: '',
      CEO: '',
      sector: '',
      companyName: ''
    }
  },
  methods: {
    update (stock) {
      // console.log(stock)
      this.getInfo(stock)
    },
    getInfo (stock) {
      console.log(stock)
      axios.get('https://financialmodelingprep.com/api/v3/profile/AAPL?apikey=a3ca968322703f3f27009b0d0cca7e4b')
        .then(res => {
          this.infoCompany = res.data[0]
          this.beta = this.infoCompany.beta
          this.CEO = this.infoCompany.ceo
          this.sector = this.infoCompany.sector
          this.companyName = this.infoCompany.companyName
        })
        .catch(err => console.log(err))
      // console.log(this.infoCompany)
    }
  }
}
</script>

<style scoped>

.card-background {
    background-color: rgba(42,11,51,0.801);
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
