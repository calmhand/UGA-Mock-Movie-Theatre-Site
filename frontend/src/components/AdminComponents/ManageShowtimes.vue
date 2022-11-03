<template>
    <div id="manage-shows-container">
        <div id="show-opts">
            <a data-bs-toggle="modal" data-bs-target="#add-show-modal"><i class="fa-solid fa-plus"></i></a>
            <!-- TODO: Implement search for showtimes? -->
            <a><i class="fa-solid fa-magnifying-glass"></i></a>
        </div>
        <div id="showtime-console">
            <table id="manage-shows-table">
                <tr>
                    <th>Movie name</th>
                    <th>Hall</th>
                    <th>Price</th>
                    <th>Booking Fee</th>
                    <th>Show Date</th>
                    <th>Show Time</th>
                    <th>Options</th>
                </tr>

                <tr>
                    <td>Top Gun</td>
                    <td>3</td>
                    <td>$15</td>
                    <td>2%</td>
                    <td>09/30/2022</td>
                    <td>9:30 AM</td>
                    <td>
                        <button>Edit</button>
                        <button>Delete</button>
                    </td>
                </tr>

                <tr>
                    <td>Top Gun</td>
                    <td>1</td>
                    <td>$18</td>
                    <td>2%</td>
                    <td>09/30/2022</td>
                    <td>4:30 PM</td>
                    <td>
                        <button>Edit</button>
                        <button>Delete</button>
                    </td>
                </tr>
            </table>
        </div>
        <AddShowtime />
    </div>
</template>

<script>
import AddShowtime from '@/components/AdminComponents/AddShowtime.vue'
export default {
    name: "ManageShowtimes",
    components: {AddShowtime,},
    methods: {
        
    }
}
</script>

<style scoped>
#manage-shows-container {
    display: none;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

#showtime-console {
    width: 100%;
}

#show-opts {
  width: 100%;
  text-align: right;
}

#manage-shows-table {
    background-color: #090b9b33;
    border: 1px solid #FBFFF1;
    margin: 10px;
}

td, th {
  border: 1px solid #FBFFF1;
  text-align: left;
  padding: 8px;
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

a {
  text-decoration: none;
  font-size: 20px;
  transition: opacity 0.2s ease-in-out;
  cursor: pointer;
}

a:hover {
  opacity: 0.7;
}

i {
  font-size: 20px;
  margin: 0 10px;
  color: #FBFFF1;
}
</style>