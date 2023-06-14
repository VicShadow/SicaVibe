<template>
<v-app>
      <v-app-bar app color="blue-grey-lighten-5">
          <div class="circle"></div>
          <v-app-bar-title class="header-text">
              SicaVibe
          </v-app-bar-title>
      </v-app-bar>
      <v-container fluid class="page-container">
        <div class="background-rect">
          <div align-items="center">
            <label class="register-title text-center">Register</label>
          </div>
          <div>
            <form>
              <v-container>
                <v-row>
                  <v-col>
                    <v-responsive>
                        <lavel>Name</lavel>
                        <v-text-field
                        type="input"
                        required
                        :style="{ 'width': '300px' }"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                  <v-col>
                    <v-responsive>
                        <lavel>Email</lavel>
                        <v-text-field
                        type="input"
                        required
                        :style="{ 'width': '300px' }"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <v-responsive>
                        <lavel>Address</lavel>
                        <v-text-field
                        type="input"
                        required
                        :style="{ 'width': '660px' }"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <v-responsive>
                        <lavel>Birthday</lavel>
                        <v-text-field
                        type="input"
                        required
                        :style="{ 'width': '300px' }"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                  <v-col>
                    <v-responsive>
                        <lavel>Phone</lavel>
                        <v-text-field
                        type="input"
                        required
                        :style="{ 'width': '300px' }"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <v-responsive>
                        <lavel>NIF</lavel>
                        <v-text-field
                        type="input"
                        required
                        :style="{ 'width': '300px' }"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                  <v-col>
                    <v-responsive>
                        <lavel>CC</lavel>
                        <v-text-field
                        type="input"
                        required
                        :style="{ 'width': '300px' }"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <v-responsive>
                        <lavel>Password</lavel>
                        <v-text-field
                        type="password"
                        required
                        :style="{ 'width': '300px' }"
                        hint="Pelo menos 8 caracteres, uma letra maiúscula, uma letra minúscula e um número"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                  <v-col>
                    <v-responsive>
                        <lavel>Confirm Password</lavel>
                        <v-text-field
                        type="password"
                        required
                        :style="{ 'width': '300px' }"
                        ></v-text-field>
                    </v-responsive>
                  </v-col>
                </v-row>
              </v-container>
            </form>
          </div>
        </div>
        </v-container>
    </v-app>>
</template>

<script lang="ts">
export default {
name: 'SignUp'
}
</script>

<style scoped>

.header-text {
  font-weight: bold;
  font-size: 2.1rem;
  color: #0D47A1;
}

.circle {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #0D47A1;
  margin-left: 25px;
  padding: 1;
}

.page-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.register-title {
  font-weight: bold;
  font-size: 1.5rem;
  color: #0D47A1;
}

.background-rect {
  width: 750px; /* Defina a largura desejada */
  height: 700px; /* Defina a altura desejada */
  background-color: #ECEFF1;
  padding: 10px;
  margin-top: 5%;
  border-radius: 0.8em;
}

</style>
