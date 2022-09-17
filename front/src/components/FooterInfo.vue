<template>
    <footer class="footer-bar">
        <div id="footer-content">
            <a id="footer-links" href="https://www.github.com/calmhand/SE4050-project">Github Repo</a>
            2022 &copy; Team 3B
        </div>
    </footer>
</template>

<script>
export default {
    name: 'FooterInfo',
}
</script>

<style>
    .footer-bar {
        height: 50px;
        background-color: black;
        font-size: 20px;
    }

    #footer-content {
        padding: 10px;
    }

    #footer-links {
        padding: 0 15px;
        text-decoration: none;
        color: #F2AF29;
    }
</style>