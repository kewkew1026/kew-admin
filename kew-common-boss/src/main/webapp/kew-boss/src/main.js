import Vue from 'vue';
import VueRouter from 'vue-router';
import routes from './router/index';
import amazeuiVue from 'kew-amazeui-vue'
Vue.config.productionTip = false

Vue.use(amazeuiVue);
Vue.use(VueRouter);

var router = new VueRouter();

var App = Vue.extend({});

router.map(routes);

router.start(App, '#app-main');
