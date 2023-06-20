import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import router from './router'
import App from '@/App.vue'

// Vuetify
import 'vuetify/styles'
import { createVuetify, type ThemeDefinition } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

// Vue Query
import { VueQueryPlugin } from '@tanstack/vue-query'

const app = createApp(App)

const mainTheme: ThemeDefinition = {
  dark: false
}

const vuetify = createVuetify({
  components,
  directives,
  theme: {
    defaultTheme: 'mainTheme',
    themes: {
      mainTheme
    }
  }
})

app.use(router)
app.use(createPinia())
app.use(vuetify)
app.use(VueQueryPlugin)

app.mount('#app')
