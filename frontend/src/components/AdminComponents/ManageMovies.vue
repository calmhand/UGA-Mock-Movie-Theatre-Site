<template>
  <div id="manage-movies-container">
    <div id="movie-opts">
      <a data-bs-toggle="modal" data-bs-target="#add-movie-modal"><i class="fa-solid fa-plus"></i></a>
      <!-- TODO: Implement search? -->
      <a href=""><i class="fa-solid fa-magnifying-glass"></i></a>
    </div>

    <div id="movie-console">
      <table id="manage-movie-table">
        <tr>
          <th>Movie name</th>
          <th>Cast</th>
          <th>Genre</th>
          <th>Release Date</th>
          <th>Options</th>
        </tr>
        <tr>
          <td>Top Gun</td>
          <td>Tom cruise, Monica Barbaro</td>
          <td>Action</td>
          <td>09/20/2022</td>
          <td>
            <button>View</button>
            <button>Edit</button>
            <button>Delete</button>
          </td>
        </tr>
        <tr>
          <td>Bullet Train</td>
          <td>Brad Pit, Joe King</td>
          <td>Thriller</td>
          <td>09/23/2022</td>
          <td>
            <button>View</button>
            <button>Edit</button>
            <button>Delete</button>
          </td>
        </tr>
      </table>
    </div>
    <AddMovie />
  </div>
</template>

<script>
import AddMovie from '@/components/AdminComponents/AddMovie.vue'
export default {
  name: "ManageMovies",
  components: {AddMovie},
  methods: {

  }
}

</script>

<style scoped>
#manage-movies-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

#movie-opts {
  width: 100%;
  text-align: right;
}

#movie-console {
  width: 100%;
}

#manage-movie-table {
    background-color: #090b9b33;
    border: 1px solid #FBFFF1;
    margin: 10px;
}

i {
  font-size: 20px;
  margin: 0 10px;
  color: #FBFFF1;
}

a {
  text-decoration: none;
  font-size: 20px;
  transition: opacity 0.2s ease-in-out;
  cursor: pointer;
}

a:hover {
  opacity: 0.7;
}

button {
  width: 100px;
  height: 45px;
  margin: 0 10px;
  border: solid 4px #FBFFF1;
  border-radius: 10px;
  text-align: center;
  transition: opacity 0.2s ease-in-out;
}

button:hover {
  opacity: 0.7;
}

td, th {
  border: 1px solid #FBFFF1;
  text-align: left;
  padding: 8px;
}
</style>