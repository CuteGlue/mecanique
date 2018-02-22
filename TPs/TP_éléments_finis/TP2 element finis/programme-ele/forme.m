function [x,N,dN] = forme (m)
%    clear all;
    close all;
    clf
    clc

    xx = linspace(-1, 1, m+1);

    condi_Nm = eye(m+1);
    x = -1:0.001:1;

    N = zeros(m+1,length(x));
    dN = zeros(m+1,length(x));

    hold on;

    for i = 1:(m+1)
        p = polyfit(xx, condi_Nm(i,:), m);
        dp = polyder(p);
        N(i,:) = polyval(p,x);
        dN(i,:) = polyval(dp,x);
    end

    subplot(1,2,1)
    plot(x,N)
    title ("fonction de forme N");
    xlabel ("xi");
    ylabel ("fonction de forme N");
    legend ("N1","N2","N3","N4","N5","N6");
    subplot(1,2,2)
    plot(x,dN)
    title ("derivation de fonction de forme dN");
    xlabel ("xi");
    ylabel ("derivation fonction de forme dN");
    legend ("dN1","dN2","dN3","dN4","dN5","dN6");
endfunction
