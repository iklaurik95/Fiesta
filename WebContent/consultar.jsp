<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar agenda</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>
<%@ page import="eus.agenda.modelo.*"%>
<%@ page import="java.util.*"%>
<%
	
	ArrayList<Fiesta> fiestas = new ArrayList<Fiesta>();
	ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();
	
	if(request.getParameter("pueblo") != null){
		String pueblo = request.getParameter("pueblo");
		
		ModeloFiesta modeloFiesta = new ModeloFiesta();
		ModeloActuacion modeloActuacion = new ModeloActuacion();
		
		if(modeloFiesta.comprobarPorPueblo(pueblo)){
			fiestas = modeloFiesta.selectPorPueblo(pueblo);
			actuaciones = modeloActuacion.selectPorPueblo(pueblo);
			
		}else{
			
			System.out.print("El pueblo insertado no aparece en la BD");
		}
			
	}
	
%>


<body>
	<div class="container">

		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<!-- formualrio para introducir el pueblo -->
				<br>
				<div class="jumbotron">
					<form action="">
						<h3>Introduce el nombre del pueblo:</h3>
						<br>
						<input type="text" name="pueblo" class="form-control"/>
						<br>
						<input type="submit" class="btn btn-default" name="consultar"	value="consultar" />
						
					</form>
				</div>
			</div>
		</div>

		<div class="row">

			<div class="col-md-4">
				<!-- datos del pueblo -->
				<p class="bg-primary">Info del pueblo</p>
				<table class="table">
					<tr>
						<th>Pueblo</th>
						<th>Nombre de fiestas</th>
						<th>Mes</th>
					</tr>
					<%for(Fiesta fiesta:fiestas){ %>
					<tr>
						<td><%=fiesta.getPueblo()%></td>
						<td><%=fiesta.getNombre()%></td>
						<td><%=fiesta.getMes()%></td>
					</tr>
					<%}%>
				</table>
				
			</div>
			<div class="col-md-8">
				<!-- datos de actuaciones -->
				<p class="bg-primary">Conciertos</p>
				<table class="table">
					<tr>
						<th>id_grupo</th>
						<th>precio</th>
					</tr>
					<%for(Actuacion actuacion:actuaciones){%>
					<tr>
						<td><%=actuacion.getId_grupo()%></td>
						<td><%=actuacion.getPrecio()%></td>
					</tr>
					<%}%>
				</table>
			</div>

		</div>

	</div>
</body>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</html>