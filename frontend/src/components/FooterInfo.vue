<template>
    <footer class="footer-bar">
        <div id="footer-content">
            <a id="footer-links" href="https://www.github.com/calmhand/SE4050-project" target="_blank">
                <i class="fa-brands fa-github"></i>
            </a>|
            <span>2022 &copy; Team 3B</span>
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
        background-color: #302b3795;
        font-size: 20px;
        opacity: 0.9;

        /* position: fixed;
        bottom: 0px;
        left: 0px;
        right: 0px;
        margin-bottom: 0px; */
    }

    #footer-content {
        padding: 10px;
    }

    #footer-links {
        padding: 0 10px;
        text-decoration: none;
        color: #FBFFF1;
    }
</style>