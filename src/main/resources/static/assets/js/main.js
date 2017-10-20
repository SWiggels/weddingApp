//jQuery(window).load() must be used instead of jQuery(document).ready() because of Webkit compatibility
jQuery(window).load(function() {
    $.get('/images', function(data){
        $('.sliderkit-nav-clip ul').append(data.thumbs);
        $('.sliderkit-panels').append(data.images);
        jQuery('#sliderkit_galery').sliderkit({
            mousewheel:false,
            keyboard:true,
            shownavitems:4,
            panelbtnshover:true,
            auto:true,
            circular:true,
            navscrollatend:true
        });
    });
});