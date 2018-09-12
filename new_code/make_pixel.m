function [x, y, pixel] = make_pixel
close all ;
% --------------------------------------------------------------------
%   input : 
%       rien
%   output
%       1. coornonnees dans l'espace réel
%       2. 9 pixels
%       3. figure de coordonnes et figure de pixel
% --------------------------------------------------------------------
x = [0 .5 1; 0 .5 1; 0 .5 1] - [.5 .5 .5; .5 .5 .5; .5 .5 .5] ;
y = [1 1 1; .5 .5 .5; 0 0 0] - [.5 .5 .5; .5 .5 .5; .5 .5 .5];

for i = 1:3
    for j = 1:3
        p(i,j) = 0;
    end
end
p(2,2) = 1 ;
pixel = p ;
% ---------real espace -----------------------------------------------
figure(1) ;
h = plot(x(:),y(:),'b*') ;
axis auto ;
grid off ;
xlabel('x') ;
ylabel('y') ;
title('espace réel') ;
saveas(h,'xyreal','png') ;

close all ;

imwrite(pixel,'figurepixel.png') ;

% -------change size of figure ----------------------------------------
%figure(2)
%tmp = imread('xyreal.png') ;
%h = imresize(tmp,[100 100]) ;
%imshow(h) ;






































