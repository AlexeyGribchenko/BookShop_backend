document.querySelector("#profileImage").addEventListener("change", () => {
    if(document.querySelector("#profileImage").value !== "") {
        document.querySelector(".upload-profile-image-btn").attributes.removeNamedItem("hidden")
    }
})
