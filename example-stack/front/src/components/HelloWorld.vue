<template>
  <div>
    <button @click="send()">test</button>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: String
    }
  },
  methods: {
    send() {
      console.log("getting...");
      console.log(this.msg);
    }
  },
  mounted() {
    fetch("/api/messages/hello")
    .then(
      (res) => res.text())
      .then((data) => {this.msg=data})
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
