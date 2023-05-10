let profileImage = document.querySelector("#profileImage");
if (profileImage !== null) {
    profileImage.addEventListener("change", () => {
        if(profileImage.value !== "") {
            document.querySelector(".upload-profile-image-btn").attributes.removeNamedItem("hidden")
        }
    })
}
