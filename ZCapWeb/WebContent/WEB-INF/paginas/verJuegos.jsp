<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<!--  Crear la interfaz de ver -->
<main class="container margin-top-10">
	<c:if test="${juegos.isEmpty() && consolaSeleccionada==null}">
			<div class="columns is-centered">
				<div class="notification is-primary column is-7 has-text-centered">
					<p>No existen juegos registrados</p>
					<a href="AgregarJuegoController.do">Agregar Juego</a>
				</div>
			</div>
	</c:if>
	<c:if test="${!juegos.isEmpty() || consolaSeleccionada !=null}">
		<div class="columns is-centered">
			<div class="column is-5">
				<form method="POST" action="VerJuegosController.do">
					<div class="field">
						<label class="label">Filtrar</label>
						<div class="control">
							<div class="select">
								<select name="filtrar-cbx">
									<c:forEach items="${consolas}" var="consola">
										<option ${consolaSeleccionada!= null && consolaSeleccionada eq consola.nombre?"selected":""} value="${consola.nombre}">${consola.nombre }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<button type="submit"
					class="button is-success">Filtrar</button>
				</form>
			</div>
		</div>
		<div class="columns is-centered">
			<div class="column is-7">
				<table class="table is-fullwidth is-bordered is-hovered is-stripped">
					<thead class="has-background-link">
						<tr>
							<th>Nombre</th>
							<th>Consola</th>
							<th>Precio</th>
							<th>Fecha de Lanzamiento</th>
							<th>Apto para niños?</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${juegos}" var="juego" >
							<tr>
								<td>${juego.nombre}</td>
								<td>${juego.consola.nombre }</td>
								<td>$ ${juego.precio}</td>
								<td>${juego.fechaTexto}</td>
								<td>${juego.esAptoNinios? "Sí": "No" }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:if>
</main>
</body>
</html>