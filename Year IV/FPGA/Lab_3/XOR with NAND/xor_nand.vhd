library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity xor_nand is
    Port ( A : in STD_LOGIC_VECTOR (1 downto 0);
           Y : out STD_LOGIC_VECTOR (2 downto 0)
         );
end xor_nand;

architecture Behavioral of xor_nand is
signal s1, s2, s3 : STD_LOGIC;

begin
    Y(0) <= A(0);
    Y(1) <= A(1);
    s1 <= not (A(0) and A(1));
    s2 <= not (A(0) and s1);
    s3 <= not (A(1) and s1);
    Y(2) <= not (s2 and s3);

end Behavioral;