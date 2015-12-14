<?php
for ($i = 0; $i <= 100; $i++) {
  printf("\033[?25lmprogress: \033[41m\033[1m %d%% %s\r\033[0m", $i, str_repeat(' ',$i) );
  usleep(1000 * 100);
}
printf("\nDone.\n\033[?25h");
?>
