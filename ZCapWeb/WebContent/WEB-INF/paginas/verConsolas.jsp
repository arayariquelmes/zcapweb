<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<!--  Crear la interfaz de ver -->
<main class="container margin-top-10">
	<div class="columns is-centered">
		<div class="column is-7">
			<c:if test="${consolas.isEmpty()}">
				<div class="notification has-text-centered is-primary">
					<p class="has-text-centered">No hay consolas ingresadas</p>
					<a href="AgregarConsolaController.do">Agregar una consola</a>
				</div>
			</c:if>
			<c:if test="${consolas.size() >0 }">
				<table class="table is-hovered is-bordered is-fullwidth is-striped">
					<thead class="has-background-primary">
						<tr>
							<th>Nombre</th>
							<th>Marca</th>
							<th>Año de Lanzamiento</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${consolas}" var="consola" >
							<tr>
								<td>${consola.nombre}</td>
								<td>${consola.marca}</td>
								<td>${consola.anio}</td>
								<td><a class="has-text-danger"
									href="VerConsolasController.do?nombreEliminar=${consola.nombre}">Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</main>
</body>
</html>