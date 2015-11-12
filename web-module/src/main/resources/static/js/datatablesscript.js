$(document).ready(function(){
    $('#table_on_functional_level').DataTable({
        responsive: true
    });
    var table_on_downgrade = $('#table_downgrade').DataTable({
        responsive: true
    });
    var table_on_upgrade = $('#table_upgrade').DataTable({
        responsive: true
    });
    table_cars_in_the_pool = $('#table_cars_in_the_pool').DataTable({
        responsive: true
    });
    $('#datatable').DataTable({
        responsive: true
    });

});
var collapseVisDownGrade = false;
var collapseVisUpGrade = false;
var collapseVisFreePool = false;
var table_cars_in_the_pool;
$('a.toggle-vis-on-downgrade').on('click', function (e) {
    e.preventDefault();

    if(!collapseVisDownGrade) {
        $('#collapseExample').show();
        collapseVisDownGrade = true;
    }
    else {
        $('#collapseExample').hide();
        collapseVisDownGrade = false;
    }
} );

$('a.toggle-vis-on-upgrade').on('click', function (e) {
    e.preventDefault();

    if(!collapseVisUpGrade) {
        $('#collapseUpgrade').show();
        collapseVisUpGrade = true;
    }
    else {
        $('#collapseUpgrade').hide();
        collapseVisUpGrade = false;
    }
} );

$('a.toggle-vis-on-free-pool').on('click', function (e) {
    e.preventDefault();
    if(!collapseVisFreePool) {
        $('#collapsefreepool').show();
        collapseVisFreePool = true;
    }
    else {

        $('#collapsefreepool').hide();
        collapseVisFreePool = false;
    }
} );

