$(function () {
   var params = getRequestParams(window.location.search);
   var uuid = params.uuid;
    $.ajax({
        url:"/blogTreatise/info/" + uuid,
        type:"GET",
        success:function(data){
            if (data.code == 200){
               var treatise = data.data.object;
               $("#treatise_body").append(treatise.treatiseBody);
            }
        }
    });
});