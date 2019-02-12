$(".star.glyphicon").click(function () {
    $(this).toggleClass("glyphicon-star glyphicon-star-empty");
    $.ajax({
        type: "GET",
        url: "addFav2?rutinaId=" + $(this).attr("rutinaId")
    });

});