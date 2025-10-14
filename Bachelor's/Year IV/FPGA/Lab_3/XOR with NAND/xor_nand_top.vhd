entity xor_nand_top is
    Port ( sw : in STD_LOGIC_VECTOR (1 downto 0);
           led : out STD_LOGIC_VECTOR (2 downto 0)
         );
end xor_nand_top;

architecture Behavioral of xor_nand_top is
component xor_nand
    Port ( A : in STD_LOGIC_VECTOR (1 downto 0);
           Y : out STD_LOGIC (2 downto 0)
         );
end component;

begin
    c1 : xor_nand port map(
        A => sw,
        Y => led
    )

end Behavioral;