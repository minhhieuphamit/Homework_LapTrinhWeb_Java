package phamminhhieu.validation.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class Product {
    private int id;
    @NotBlank(message = "Tên không được để trống")
    private String name;
    @Length(min = 5, max = 200, message = "Độ dài ảnh từ 5 đến 200 ký tự")
    private String image;
    @NotNull(message = "Giá không được để trống")
    @Min(value = 1, message = "Giá không được nhỏ hơn 1")
    @Max(value = 999999999, message = "Giá không được lớn hơn 999999999 tỷ")
    private long price;
}
