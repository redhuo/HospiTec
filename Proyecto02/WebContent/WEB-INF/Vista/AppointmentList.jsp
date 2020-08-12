<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.dataTables.min.css">
    <link rel="stylesheet" type="https://cdn.datatables.net/responsive/2.2.5/css/responsive.bootstrap.min.css">
    <link href="./css/bootstrap-responsive.css" rel="stylesheet">
  </head>
  <body>
    <h1>Appointment list</h1>
    <table id="example" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Area</th>
                <th>Date</th>
                <th>Hour</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>01</td>
                <td>Ortopedia</td>
                <td>2020/03/20</td>
                <td>3:30pm</td>
                <td>Registrada</td>
            </tr>
            <tr>
                <td>02</td>
                <td>Cirugia</td>
                <td>2020/03/20</td>
                <td>12pm</td>
                <td>Realizada</td>
            </tr>
            
            <tr>
                <td>03</td>
                <td>Ortopedia</td>
                <td>2020/11/20</td>
                <td>2:30pm</td>
                <td>Registrada</td>
            </tr>
             <tr>
                <td>04</td>
                <td>Ortopedia</td>
                <td>2020/11/20</td>
                <td>2:30pm</td>
                <td>Asignada</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <th>ID</th>
                <th>Area</th>
                <th>Date</th>
                <th>Hour</th>
                <th>Status</th>
            </tr>
        </tfoot>
    </table>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" class="init">
    $(document).ready(function() {
        // Setup - add a text input to each footer cell
        $('#example thead tr').clone(true).appendTo( '#example thead' );
        $('#example thead tr:eq(1) th').each( function (i) {
            var title = $(this).text();
            $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
     
            $( 'input', this ).on( 'keyup change', function () {
                if ( table.column(i).search() !== this.value ) {
                    table
                        .column(i)
                        .search( this.value )
                        .draw();
                }
            } );
        } );
     
        var table = $('#example').DataTable( {
            orderCellsTop: true,
            fixedHeader: true
        } );
    } );
    </script>
  </body>
</html>