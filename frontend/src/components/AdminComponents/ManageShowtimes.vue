<template>
    <div id="manage-shows-container">
        <div id="allshows-container">
            <h1>Shows</h1>
            <table>
                <tr>
                <th>Movie name</th>
                <th>Hall</th>
                <th>price</th>
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
                <td><button>Edit</button>
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
                <td><button>Edit</button>
                    <button>Delete</button>
                </td>
                </tr>
            </table>
            </div>

            <div id="addshow-container">
            <button @click="openAddShowForm()">Add Show</button>
            <div id="addshow-form-container">
                <form id="add-show-form">
                <div class="labels">
                    <label for="dropdownMovieName">Movie Name</label>
                </div>
                <div class="input-tab">
                    <select id="dropdown" name="dropdownMovieName">
                    <option disabled value selected>Select a Movie</option>
                    <option value="Top Gun">Top Gun</option>
                    <option value="Bullet Train">Bullet Train</option>
                    </select>
                </div>

                <div class="labels">
                    <label for="hall">Hall</label>
                </div>
                <div class="input-tab">
                    <input class="input-field" type="number" name="hall">
                </div>

                <div class="labels">
                    <label for="price">price</label>
                </div>
                <div class="input-tab">
                    <input class="input-field" type="number" name="price">
                </div>

                <div class="labels">
                    <label for="bookingFee">Booking Fee</label>
                </div>
                <div class="input-tab">
                    <input class="input-field" type="number" name="bookingFee">
                </div>

                <div class="labels">
                    <label for="showDate">Show Date</label>
                </div>
                <div class="input-tab">
                    <input class="input-field" type="date">
                </div>

                <div class="labels">
                    <label for="showTime">Show Time</label>
                </div>
                <div class="input-tab">
                    <input class="input-field" type="time" name="showTime">
                </div>
                <!-- <div class="submission">
                <button type="submit" @click="saveshow()">Save</button>
                <button @click="closeAddShowForm()">Cancel</button>
                </div> -->
                <!-- added outside </form> as submit is messing up url path-->
                </form>
                <div class="submission">
                <button @click="saveshow()">Save</button>
                <button @click="closeAddShowForm()">Cancel</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ManageShowtimes",

    }
</script>

<style scoped>
#manage-shows-container {
    display: none;
}

#add-show-form {
  margin: 0 auto;
  width: 100%;
  padding: 10px;
}

#addshow-form-container {
  display: none;
}

</style>