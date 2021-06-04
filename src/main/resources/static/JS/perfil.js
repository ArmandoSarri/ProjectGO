console.log("4");
window.onload = function(){

	$("input[type=file]").change(function(){
console.log("2");
        if (this.files && this.files[0]) {
        console.log("3");
            var reader = new FileReader();

            reader.readAsDataURL(this.files[0]);

            reader.onload = function (e) {
                $("#imagen").attr("src", e.target.result);
            }
        }
    });
    
     $("#container-usuario").click(function() {
        $(".nav-dropdown").slideToggle("slow");
    });
    
}