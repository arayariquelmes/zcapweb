<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:include page="../templates/header.jsp"  />
	<main class="container margin-top-10">

		<div class="columns is-centered">
			<!--  Recibir peticiones
			Forma 1 con Scriptlets -->
			<%
				//Se definio un atributo desde el Servlet???
				if(request.getAttribute("mensaje") != null){
					%>
						<div class="notification is-info column is-6">
							<p> <%= (String)request.getAttribute("mensaje") %></p>
						</div>
					<% 
				}
			%>
			<!--  Forma 2: usando jstl -->
			<c:if test="${errores != null}" >
				<div class="notification is-warning column is-8">
					<ul>
						<c:forEach items="${errores }" var="error" >
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
		</div>
		<div class="columns is-centered ">

			<div class="column is-6">
				<form method="POST" action="AgregarConsolaController.do"  >
					<div class="card">
						<div class="card-header has-background-warning">
							<span class="card-header-title">Agregar Consola</span>
						</div>
						<div class="card-content">
							<div class="field">
								<label class="label" for="nombre-txt">Nombre</label>
								<div class="control">
									<input type="text" name="nombre-txt" class="input" placeholder="ingrese nombre"  />
								</div>
							</div>
							<div class="field">
								<label class="label" for="marca-select">Marca</label>
								<div class="control">
									<div class="select">
										<select name="marca-select">
											<option value="">Seleccione Marca</option>
											<option value="Microsoft">Microsoft</option>
											<option>Nintendo</option>
											<option>Sony</option>
										</select>
									</div>
								</div>
							</div>
							<div class="field">
								<label class="label" for="anio-txt">Año de Lanzamiento</label>
								<div class="control">
									<input type="number" min="1988" max="2020" class="input" name="anio-txt" />
								</div>
							</div>
						</div>
						<div class="card-footer columns is-centered">
							<div class="column is-4">
								<!-- Los elementos de tipo submit envian formularios -->
								<button type="submit" class="button is-primary" >Agregar</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</main>
</body>
</html>