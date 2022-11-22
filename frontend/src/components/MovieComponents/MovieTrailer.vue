<template>
  <div id="trailer-container">
      <img v-show="show" id="trailer-background" class="w-100" :src="this.imageURL">
      <div id="trailer-info">
        <span style="font-size: 10px;">FEATURE FILM</span>
        <span id="trailer-title">
          <strong>{{this.title}} &nbsp;</strong>
          <button id="trailer-btn" type="button" class="btn btn-primary" data-bs-toggle="modal" :data-bs-target="`#trailerModal` + this.trailerNum">
            <i class="fa-solid fa-play" style="font-size: 15px; opacity: 0.9;">&nbsp; Trailer</i>
          </button>
        </span>
        <article>{{this.description}}</article>
      </div>
      <div id="poster-container"><img v-show="show" id="trailer-poster" :src="this.imageURL"></div>
    </div>
    <TrailerModal :link="this.trailerLink" :trailerId="this.trailerNum"/>
</template>

<script>
import TrailerModal from './TrailerModal.vue'
export default {
    name: 'MovieTrailer',
    components: {TrailerModal},
    props: {
        trailerNum: Number,
    },
    data() {
      return {
        show: false,
        description: '',
        title : '',
        movieID: 0,
        index: 0,
        trailerLink: '',
        imageURL: ''
      }
    },
    methods: {
      // TODO: Fetch from DB rather than straight from API.
      async getData() {
        // Get Movie Information
        await fetch('https://api.themoviedb.org/3/movie/upcoming?api_key=f3ac6beeff1af51dfca6c7f4e3d29fae')
        .then((res) => res.json())
        .then((data) => {
          var movieData = data.results[this.trailerNum]
          this.description = movieData.overview
          this.movieID = movieData.id
          this.title = movieData.title
          this.imageURL += 'https://image.tmdb.org/t/p/w500' + movieData.poster_path
          this.show = true
          // console.log(this.imageURL)
          // console.log(movieData);
        }).catch((err)=>{console.log("Err: " + err);})

        // Create Trailer Link
        await fetch('https://api.themoviedb.org/3/movie/'+ this.movieID + '/videos?api_key=f3ac6beeff1af51dfca6c7f4e3d29fae')
        .then((vid_res) => vid_res.json())
        .then((vid_data) => {
          var movieVids = vid_data.results
          for (let i = 0; i < movieVids.length; i++) {
            if (movieVids[i].name.includes('Trailer')) {
              this.trailerLink += 'https://www.youtube.com/embed/' + movieVids[i].key
              break
            }
          }
        }).catch((res)=>{console.log(res);})
      }
    },
    beforeMount() {
      this.getData()
    }
}
</script>

<style scoped>
  #trailer-container {
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  #trailer-info {
    display: flex;
    flex-direction: column;
    text-align: left;
    padding: 50px;
    width: 100%;
    z-index: 1;
  }

  #trailer-title {
    color: #FBFFF1;
    font-size: 4rem;
    margin: 0;
  }

  #trailer-poster {
    height: 340px;
    z-index: 1;
  }

  #poster-container {
    z-index: 1;
    
  }

  #trailer-background {
    position: absolute;
    z-index: 0;
    filter: blur(5px) opacity(50%);
    background-color: #3C3744;
  }

  #trailer-btn {
    background-color: rgba(0, 0, 0, 1); 
    border-color: rgba(0, 0, 0, 1);
  }

  article {
    color: #FBFFF1;
    font-size: 1.2em;
  }
</style>