package Gabransel.RegisterLogin.dto;

public record ErrorResponseDto(String timestamp, int status, String error, String message) {
}
