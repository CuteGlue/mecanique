function make_pixel(N1,N2,vol)

% -------------------------------------------------------------------------
%
%
%
%
% -------------------------------------------------------------------------

r = N1*N2*vol/pi ;
for i = 1:N1
    for j = 1:N2
        if (i-(N1+1)/2)^2+(j-(N2+1)/2)^2 < r
            p(i,j) = 1 ;
        else
            p(i,j) = 0 ;
        end
    end
end
pixel = p ;
imwrite(pixel,'figure_pixel.png') ;