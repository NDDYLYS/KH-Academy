<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <!-- 컨테이너 -->
    <div class="container-fluid mt-4">
        <div class="row">
            <div class="col-md-4 offset-md-4 col-sm-10 offset-sm-1">
                <!-- 컨텐츠 내용 -->
                <div class="row mt-4">
                    <div class="col">
                        <div class="d-flex justify-content-end">
                            <a href = "add" class = "btn btn-primary">포켓몬 등록</a>
                        </div>
                    </div>
                </div>

                <div class="row mt-4">
                    <div class="col">
                        <div class="text-nowrap table-responsive">
                            <table class="table table-bordered table-striped table-hover">
                                <thead>
					                <tr>
					                    <th>번호</th>
					                    <th>이미지</th>
					                    <th>이름</th>
					                    <th>속성</th>
					                    <th><i class="fa-solid fa-heart red"></i></th>
					                </tr>
					            </thead>

					            <tbody>
									<c:forEach var="pokemonDto" items="${ pokemonList }">
										<tr>
											<td>${ pokemonDto.getPokemonNo() }</td>
											<td><img src = "/pokemon/image?pokemonNo=${pokemonDto.getPokemonNo()}" width="32" height = "32"></td>
											<td><a href="detail?pokemonNo=${pokemonDto.getPokemonNo()}">${ pokemonDto.getPokemonName() }</a></td>
											<td>${ pokemonDto.getPokemonType() }</td>
											<td><i class="fa-regular fa-heart red"></i>${pokemonDto.pokemonLike }</td>
										</tr>
									</c:forEach>
					            </tbody>
            
					            <tfoot>
									<tr>
										<td colspan="7">
											검색결과 : 
											${pageVO.begin} - ${pageVO.end}
											/
											${pageVO.dataCount}개
										</td>
									</tr>
									
									<tr>
										<td>
											<jsp:include page="/WEB-INF/views/template/pagination2.jsp"></jsp:include>
										</td>
									</tr>
								</tfoot>
        					</table>
						</div>
                    </div>
                </div>

                <div class="row mt-4">
                    <div class="col">
                        <div class="d-flex justify-content-end">
                            <a href = "add" class = "btn btn-primary">포켓몬 등록</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>