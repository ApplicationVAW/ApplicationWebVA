$(function()
{   var i=1;
    $('#calc:first').find('.input-group-addon').html(i);
    $(document).on('click', '.btn-add', function(e)
    {
        e.preventDefault();

        var controlForm = $('#calc:first'),
            currentEntry = $(this).parent('.entry:first'),
            newEntry = $(currentEntry.clone()).appendTo(controlForm);
            $(newEntry).find('.input-group-addon').html(++i);

        newEntry.find('input').val('');
        controlForm.find('.entry:not(:last) .btn-add')
            .removeClass('btn-add').addClass('btn-remove')
            .removeClass('btn-success').addClass('btn-danger')
            .html('<span class="glyphicon glyphicon-minus"></span>');
    }).on('click', '.btn-remove', function(e)
    {   i--;
        $(this).parent().nextAll('.entry').each(function() {
            $(this).find('.input-group-addon').html($(this).find('.input-group-addon').html()-1); 
        });
		$(this).parents('.entry:first').remove();	
		e.preventDefault();
		return false;
	});
});
