library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity sw_led is
	Port ( A : in STD_LOGIC_VECTOR (7 downto 0);
		   Y : out STD_LOGIC_VECTOR (7 downto 0)
		 );

end sw_led;

architecture Behavioral of sw_led is
begin
	Y <= A;
	
end Behavioral;