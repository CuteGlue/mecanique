function B = Bk (m)
  B = zeros(m+1,1);
  [x,N,dN] = forme (m);
  G = zeros(1,length(x));
  
  for i = 1: (m+1)
    for q = 1: length(x)
      xi = (x(q)+1)/2
      G(q)= - xi*N(i,q)*(1-xi**4)/2
    end
      B(i)= trapz(x,G)
  end
  
endfunction
  