<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp" />
<main class="container margin-top-10">
	<c:if test="${errores != null }">
		<div class="columns is-centered">
			<div class="notification is-warning is-column-7">
				<ul>
					<c:forEach items="${errores }" var="error">
						<li>${error}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:if>
	<div class="columns is-centered">
		<div class="column is-4">
			<form method="POST" action="AgregarJuegoController.do">
				<div class="card">
					<div class="card-header has-background-warning">
						<h1 class="card-header-title">Agregar Juego</h1>
					</div>
					<div class="card-content">
						<div class="field">
							<label for="nombre-txt" class="label">Nombre</label>
							<div class="control">
								<input class="input" name="nombre-txt" type="text" placeholder="Ingrese nombre de juego" />
							</div>
						</div>
						<div class="field">
							<label for="descripcion-txt" class="label">Descripción</label>
							<div class="control">
								<textarea name="descripcion-txt" class="textarea" placeholder="Descripcion"></textarea>
							</div>
						</div>
						<div class="field">
							<label class="label" for="consola-cbx">Consola</label>
							<div class="control">
								<div class="select">
									<select name="consola-cbx">
										<option disabled> Seleccione Consola</option>
										<c:forEach items="${consolas}" var="consola">
											<option value="${consola.nombre}">${consola.nombre}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="field">
							<label class="label" for="apto-rb">Apto para niños</label>
							<div class="control">
								<label class="radio">
									<input type="radio" name="apto-rb" value="si" checked />
									Sí
								</label>
								<label class="radio">
									<input type="radio" name="apto-rb" value="no" />
									No
								</label>
							</div>
						</div>
						<div class="field">
							<label class="label" for="precio-txt">Precio</label>
							<div class="control">
								<input type="number" name="precio-txt" class="input" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="fecha-txt">Fecha de Lanzamiento</label>
							<div class="control">
								<input type="date" name="fecha-txt"  class="input" />
							</div>
						</div>
					</div>
					<div class="card-footer columns is-centered">
						<div class="column is-4 ">
							<button type="submit" class="button is-link">Registrar</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</main>
</body>
</html>